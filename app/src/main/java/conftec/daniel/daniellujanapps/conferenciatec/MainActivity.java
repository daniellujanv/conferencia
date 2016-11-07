package conftec.daniel.daniellujanapps.conferenciatec;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.flybits.core.api.Flybits;
import com.flybits.core.api.interfaces.IRequestPaginationCallback;
import com.flybits.core.api.models.Pagination;
import com.flybits.core.api.models.Zone;
import com.flybits.core.api.models.ZoneMoment;
import com.flybits.core.api.utils.filters.ZoneMomentOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import conftec.daniel.daniellujanapps.conferenciatec.adapters.MomentsAdapter;
import conftec.daniel.daniellujanapps.conferenciatec.objects.ConferenceMoment;


public class MainActivity extends AppCompatActivity implements MomentsAdapter.ClickInterface {

    private final String TAG = getClass().getSimpleName();

    @BindView(R.id.main_recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.main_progressbar)
    ProgressBar mProgressBar;

    private MomentsAdapter mMomentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMomentsAdapter = new MomentsAdapter(getApplicationContext(), this);

        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mMomentsAdapter);

        mProgressBar.setVisibility(View.VISIBLE);
        getFlybitsZone();
    }



    private void getFlybitsZone(){
        Flybits.include(MainActivity.this)
                .getZones(null, new IRequestPaginationCallback<ArrayList<Zone>>() {
                    @Override
                    public void onSuccess(ArrayList<Zone> zones, Pagination pagination) {
                        Log.i(TAG, "ZONES :: "+zones.size());

                        if(zones.size() > 0){
                            getFlybitsMoments(zones.get(0).id);
                        }
                    }

                    @Override
                    public void onException(Exception e) {

                    }

                    @Override
                    public void onFailed(String s) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                });
    }

    private void getFlybitsMoments(String zoneId){
        ZoneMomentOptions options = new ZoneMomentOptions.Builder()
                .addZoneId(zoneId)
                .addPaging(100, 0)
                .build();

        Flybits.include(MainActivity.this)
                .getZoneMoments(options, new IRequestPaginationCallback<ArrayList<ZoneMoment>>() {
                    @Override
                    public void onSuccess(ArrayList<ZoneMoment> zoneMoments, Pagination pagination) {
                        mMomentsAdapter.setMoments(zoneMoments);
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onException(Exception e) {

                    }

                    @Override
                    public void onFailed(String s) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                });
    }

    @Override
    public void onClickConference(ConferenceMoment conferenceMoment) {

        DialogFragment conferenceDetailFragment = new ConferenceDetailFragment();
        ((ConferenceDetailFragment)conferenceDetailFragment).setConference(conferenceMoment);
        conferenceDetailFragment.show(
                getSupportFragmentManager(), "DETAIL");

        Toast.makeText(this, "showing detail", Toast.LENGTH_SHORT).show();
    }
}
