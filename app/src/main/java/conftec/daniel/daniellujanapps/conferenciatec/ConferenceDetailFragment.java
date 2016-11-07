package conftec.daniel.daniellujanapps.conferenciatec;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import conftec.daniel.daniellujanapps.conferenciatec.objects.ConferenceMoment;

/**
 * Created by DanielLujanApps on domingo06/11/16.
 *
 */

public class ConferenceDetailFragment extends DialogFragment {

    private ConferenceMoment mConferenceMoment;

    @BindView(R.id.detail_title)
    TextView mTitleView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout to use as dialog or embedded fragment
        View view = inflater.inflate(R.layout.conference_detail, container, false);
        ButterKnife.bind(this, view);

        mTitleView.setText(mConferenceMoment.getTitle());

        return view;
    }

    public void setConference(ConferenceMoment conference){
        mConferenceMoment = conference;
    }
}
