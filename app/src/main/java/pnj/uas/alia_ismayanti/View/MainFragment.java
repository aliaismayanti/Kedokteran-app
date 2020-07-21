package pnj.uas.alia_ismayanti.View;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uas.alia_ismayanti.EasyLocation;
import pnj.uas.alia_ismayanti.EasyLocationCallbacks;
import pnj.uas.alia_ismayanti.SelectedLocation;
import pnj.uas.alia_ismayanti.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        EasyLocation easyLocation = new EasyLocation.Builder(this,"AIzaSyDN5ddrih49nZYoZ4Fzf4VcB1cFqtXg448")
                .showCurrentLocation(true)
                .useGeoCoder(true)
                .setResultOnBackPressed(false)
                .setCallbacks(new EasyLocationCallbacks() {
                    @Override
                    public void onSuccess(SelectedLocation location) {
                        Toast.makeText(requireContext(), location.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed(String reason) {
                        Toast.makeText(requireContext(), reason, Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
