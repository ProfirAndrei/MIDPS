package andrei.profir.pomodoro.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import andrei.profir.pomodoro.R;
import andrei.profir.pomodoro.activities.MainActivity;
import andrei.profir.pomodoro.activities.MapsActivity;
import andrei.profir.pomodoro.activities.SettingsActivity;

public class ListItemsFragment extends ListFragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_items, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Items,
                android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        switch (position) {
            case 0:
                MainActivity.CURRENT_ITEM = 1;
                startActivity(new Intent(getContext(), SettingsActivity.class));
                break;
            case 1:
                MainActivity.CURRENT_ITEM = 1;
                startActivity(new Intent(getActivity(), MapsActivity.class));
                break;
            case 2:
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage(getString(R.string.about_message));
                alert.setTitle(getString(R.string.about_title));
                alert.setCancelable(true);
                alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                });
                alert.show();
                break;
        }
    }
}