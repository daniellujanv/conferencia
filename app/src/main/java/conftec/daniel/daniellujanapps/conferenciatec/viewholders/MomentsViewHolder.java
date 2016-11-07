package conftec.daniel.daniellujanapps.conferenciatec.viewholders;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import conftec.daniel.daniellujanapps.conferenciatec.R;
import conftec.daniel.daniellujanapps.conferenciatec.adapters.MomentsAdapter;
import conftec.daniel.daniellujanapps.conferenciatec.objects.ConferenceMoment;

/**
 * Created by DanielLujanApps on domingo06/11/16.
 *
 */

public class MomentsViewHolder extends RecyclerView.ViewHolder {

    private ConferenceMoment mConferenceMoment;

    @BindView(R.id.title)
    TextView mTitleView;
    @BindView(R.id.hours)
    TextView mHoursView;
    @BindView(R.id.team)
    TextView mTeamView;
    @BindView(R.id.description_short)
    TextView mDescriptionShortView;

    View conferenceView;

    private Context mContext;
    private MomentsAdapter.ClickInterface mListener;

    public MomentsViewHolder(View itemView, MomentsAdapter.ClickInterface listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mContext = itemView.getContext();
        conferenceView = itemView;
        mListener = listener;
    }

    public void setMoment(final ConferenceMoment conferenceMoment, int position){
        mConferenceMoment = conferenceMoment;
        setInfo(position);

        conferenceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickConference(conferenceMoment);
            }
        });
    }

    private void setInfo(int position){

        int darkColor = R.color.md_pink_100;
        int lightColor = R.color.md_pink_50;
        switch (position%10) {
            case 0:
                darkColor = R.color.md_orange_100;
                lightColor = R.color.md_orange_50;
                break;
            case 1:
                darkColor = R.color.md_teal_100;
                lightColor = R.color.md_teal_50;
                break;
            case 2:
                darkColor = R.color.md_lime_100;
                lightColor = R.color.md_lime_50;
                break;
            case 3:
                darkColor = R.color.md_amber_100;
                lightColor = R.color.md_amber_50;
                break;
            case 4:
                darkColor = R.color.md_light_green_100;
                lightColor = R.color.md_light_green_50;
                break;
            case 5:
                darkColor = R.color.md_cyan_100;
                lightColor = R.color.md_cyan_50;
                break;
            case 6:
                darkColor = R.color.md_blue_gray_100;
                lightColor = R.color.md_blue_gray_50;
                break;
            case 7:
                darkColor = R.color.md_deep_purple_100;
                lightColor = R.color.md_deep_purple_50;
                break;
            case 8:
                darkColor = R.color.md_indigo_100;
                lightColor = R.color.md_indigo_50;
                break;
            case 9:
                darkColor = R.color.md_light_blue_100;
                lightColor = R.color.md_light_blue_50;
        }



            mTitleView.setText(mConferenceMoment.getTitle());
            mTitleView.setBackgroundColor(
                    ContextCompat.getColor(mContext, lightColor));
            mHoursView.setText(
                    String.format(
                            mContext.getString(R.string.conference_hours),
                            mConferenceMoment.getStarts(), mConferenceMoment.getEnds()));
            mHoursView.setBackgroundColor(
                    ContextCompat.getColor(mContext, darkColor));
            mTeamView.setText(mConferenceMoment.getTeam());
            mDescriptionShortView.setText(mConferenceMoment.getDescriptionShort());
    }

}
