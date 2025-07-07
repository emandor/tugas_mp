package com.ubl.tugas_mp;

import android.widget.Toast;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GalleryFragment extends Fragment {

    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        ImageView imageView = view.findViewById(R.id.img_dzaki);
        Button btnDetail = view.findViewById(R.id.btn_detail);

        imageView.setOnClickListener(v -> {
            if (mediaPlayer != null) mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.intro);
            if (mediaPlayer != null) {
                mediaPlayer.start();
            } else {
                Toast.makeText(getContext(), "Audio gagal diputar", Toast.LENGTH_SHORT).show();
            }
        });

        btnDetail.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new DetailFragment())
                .addToBackStack(null)
                .commit();
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer != null) mediaPlayer.release();
    }
}
