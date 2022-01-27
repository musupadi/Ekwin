package com.ascendant.ekwin.Activity.ui.Home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ascendant.ekwin.Activity.ui.Home.Data.DataActivity;
import com.ascendant.ekwin.Activity.ui.Home.Jadwal.JadwalActivity;
import com.ascendant.ekwin.Activity.ui.Home.Materi.MateriActivity;
import com.ascendant.ekwin.Activity.ui.Home.Pendeta.PendetaActivity;
import com.ascendant.ekwin.Activity.ui.Home.Tema.TemaActivity;
import com.ascendant.ekwin.Activity.ui.Home.Umur.UmurActivity;
import com.ascendant.ekwin.R;
import com.ascendant.ekwin.SharedPreferance.DB_Helper;

public class HomeFragment extends Fragment {
    CardView cardJadwal,cardMateri,cardUmur,cardPendeta,cardTema,cardData;
    ImageView Logout;
    DB_Helper dbHelper;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper=new DB_Helper(getActivity());
        Logout = view.findViewById(R.id.ivLogout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                // Set a title for alert dialog
                builder.setTitle("Pemberitahuan");

                // Ask the final question
                builder.setMessage("Apakah Anda Yakin Ingin Logout ? ");

                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when user clicked the Yes button
                        // Set the TextView visibility GONE
                        dbHelper.userLogout(getActivity());
                    }
                });

                // Set the alert dialog no button click listener
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when No button clicked
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }
        });
        cardJadwal = view.findViewById(R.id.cardJadwal);
        cardMateri = view.findViewById(R.id.cardMateri);
        cardUmur = view.findViewById(R.id.cardUmur);
        cardPendeta = view.findViewById(R.id.cardPendettal);
        cardTema = view.findViewById(R.id.cardTema);
        cardData = view.findViewById(R.id.cardData);
        cardJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), JadwalActivity.class);
                startActivity(intent);
            }
        });
        cardMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MateriActivity.class);
                startActivity(intent);
            }
        });
        cardUmur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UmurActivity.class);
                startActivity(intent);
            }
        });
        cardPendeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PendetaActivity.class);
                startActivity(intent);
            }
        });
        cardTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TemaActivity.class);
                startActivity(intent);
            }
        });
        cardData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DataActivity.class);
                startActivity(intent);
            }
        });
    }
}