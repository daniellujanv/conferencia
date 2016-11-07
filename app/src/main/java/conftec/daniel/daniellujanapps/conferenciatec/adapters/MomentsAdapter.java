package conftec.daniel.daniellujanapps.conferenciatec.adapters;

import android.content.Context;
import android.net.sip.SipAudioCall;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flybits.core.api.models.ZoneMoment;
import com.google.gson.Gson;

import java.util.ArrayList;

import conftec.daniel.daniellujanapps.conferenciatec.R;
import conftec.daniel.daniellujanapps.conferenciatec.objects.ConferenceMoment;
import conftec.daniel.daniellujanapps.conferenciatec.viewholders.MomentsViewHolder;

/**
 * Created by DanielLujanApps on domingo06/11/16.
 *
 */

public class MomentsAdapter extends RecyclerView.Adapter<MomentsViewHolder> {

    private ArrayList<ConferenceMoment> mMoments = new ArrayList<>();

    private Context mContext;
    ClickInterface mListener;

    public MomentsAdapter(Context context, ClickInterface listener){
        mContext = context;
        mListener = listener;
    }

    @Override
    public MomentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View conferenceView = LayoutInflater.from(mContext)
                .inflate(R.layout.conference_item, parent, false);
        return new MomentsViewHolder(conferenceView, mListener);
    }

    @Override
    public void onBindViewHolder(MomentsViewHolder holder, int position) {
        holder.setMoment(mMoments.get(position), holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return mMoments.size();
    }

    public void setMoments(ArrayList<ZoneMoment> moments){

        if(moments.size() > 0){
            Gson gson = new Gson();
            for(ZoneMoment zoneMoment : moments){
                mMoments.add(
//                        gson.fromJson(zoneMoment.metadataAsString, ConferenceMoment.class)
                    new ConferenceMoment()
                );
            }
            notifyDataSetChanged();
        }

    }

    public interface ClickInterface {
        void onClickConference(ConferenceMoment conferenceMoment);
    }
}
