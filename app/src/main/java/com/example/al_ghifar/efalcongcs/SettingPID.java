package com.example.al_ghifar.efalcongcs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingPID extends AppCompatDialogFragment {
    private EditText setRollP, setRollI, setRollD, setPitchP, setPitchI, setPitchD, setYawP, setYawI, setYawD, setAltP, setAltI, setAltD, setPosP, setPosI, setPosD;
    private TextView tvsRoll, tvsPitch, tvsYaw, tvsAlt, tvsPos;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog_pid, null);

        builder.setView(view)
                .setTitle("Setting PID")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String rollp = setRollP.getText().toString();
                        String rolli = setRollI.getText().toString();
                        String rolld = setRollD.getText().toString();

                        String pitchp = setPitchP.getText().toString();
                        String pitchi = setPitchI.getText().toString();
                        String pitchd = setPitchD.getText().toString();

                        String yawp = setYawP.getText().toString();
                        String yawi = setYawI.getText().toString();
                        String yawd = setYawD.getText().toString();

                        listener.applyTexts(rollp,rolli,rolld,pitchp,pitchi,pitchd,yawp,yawi,yawd);
                    }
                });

        tvsRoll = view.findViewById(R.id.Roll);
        tvsPitch = view.findViewById(R.id.Pitch);
        tvsYaw = view.findViewById(R.id.Yaw);
        tvsAlt = view.findViewById(R.id.Altitude);
        tvsPos = view.findViewById(R.id.Pos);

        setRollP = view.findViewById(R.id.rollP);
        setRollI = view.findViewById(R.id.rolli);
        setRollD = view.findViewById(R.id.rollD);

        setPitchP = view.findViewById(R.id.pitchP);
        setPitchI = view.findViewById(R.id.pitchI);
        setPitchD = view.findViewById(R.id.pitchD);

        setYawP = view.findViewById(R.id.yawP);
        setYawI = view.findViewById(R.id.yawI);
        setYawD = view.findViewById(R.id.yawD);

        setAltP = view.findViewById(R.id.altP);
        setAltI = view.findViewById(R.id.altI);
        setAltD = view.findViewById(R.id.altD);

        setPosP = view.findViewById(R.id.posP);
        setPosI = view.findViewById(R.id.posI);
        setPosD = view.findViewById(R.id.posD);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener = (DialogListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }

    }

    public interface DialogListener{
        void applyTexts(String rollp, String rolli, String rolld, String pitchp, String pitchi, String pitchd, String yawp, String yawi, String yawd);
    }
}
