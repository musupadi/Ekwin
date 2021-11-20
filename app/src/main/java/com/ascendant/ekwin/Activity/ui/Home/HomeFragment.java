package com.ascendant.ekwin.Activity.ui.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ascendant.ekwin.Activity.ui.Home.Jadwal.JadwalActivity;
import com.ascendant.ekwin.Activity.ui.Home.Materi.MateriActivity;
import com.ascendant.ekwin.Activity.ui.Home.Umur.UmurActivity;
import com.ascendant.ekwin.R;
import com.ascendant.ekwin.SharedPreferance.DB_Helper;

public class HomeFragment extends Fragment {
    CardView cardJadwal,cardMateri,cardUmur;
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
                dbHelper.userLogout(getActivity());
            }
        });
        cardJadwal = view.findViewById(R.id.cardJadwal);
        cardMateri = view.findViewById(R.id.cardMateri);
        cardUmur = view.findViewById(R.id.cardUmur);

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
    }
}