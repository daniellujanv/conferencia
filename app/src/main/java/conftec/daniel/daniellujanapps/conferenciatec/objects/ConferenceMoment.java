package conftec.daniel.daniellujanapps.conferenciatec.objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielLujanApps on domingo06/11/16.
 */

public class ConferenceMoment {

    @SerializedName("title")
    String mTitle;
    @SerializedName("subtitle")
    String mSubtitle;
    @SerializedName("description_short")
    String mDescriptionShort;
    @SerializedName("description_long")
    String getmDescriptionLong;
    @SerializedName("image")
    String mImageUrl;
    @SerializedName("starts")
    String mStarts;
    @SerializedName("ends")
    String mEnds;
    @SerializedName("team")
    String mTeam;

    public ConferenceMoment(){
        mTitle = "Example of Title for Conference";
        mSubtitle = "Example of Subtitle for Conference";
        mDescriptionShort = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id ligula" +
                " eu turpis maximus luctus quis ac nisl. Cras porttitor odio a blandit vulputate.";
        getmDescriptionLong = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id " +
                "ligula eu turpis maximus luctus quis ac nisl. Cras porttitor odio a blandit " +
                "vulputate. Aenean tellus nisi, volutpat quis massa in, congue vulputate nulla. " +
                "Duis suscipit tempor sem non viverra. Nulla lobortis libero ac vestibulum aliquam." +
                " Morbi sapien quam, hendrerit sed tellus et, laoreet accumsan massa. Vivamus " +
                "leo sem, volutpat non tristique non, convallis ut magna. Curabitur mattis sodales " +
                "libero vitae egestas.";
        mImageUrl = " https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/" +
                "public/topic_images/2014/Cell-Phone-Plans-topic-page-graphic.png?itok=QMawtS_h";
        mStarts = "10:00";
        mEnds = "11:00";
        mTeam = "Mobility";
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public void setSubtitle(String mSubtitle) {
        this.mSubtitle = mSubtitle;
    }

    public String getDescriptionShort() {
        return mDescriptionShort;
    }

    public void setDescriptionShort(String mDescriptionShort) {
        this.mDescriptionShort = mDescriptionShort;
    }

    public String getGetDescriptionLong() {
        return getmDescriptionLong;
    }

    public void setGetDescriptionLong(String getmDescriptionLong) {
        this.getmDescriptionLong = getmDescriptionLong;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getStarts() {
        return mStarts;
    }

    public void setStarts(String mStarts) {
        this.mStarts = mStarts;
    }

    public String getEnds() {
        return mEnds;
    }

    public void setEnds(String mEnds) {
        this.mEnds = mEnds;
    }

    public String getTeam() {
        return mTeam;
    }

    public void setTeam(String mTeam) {
        this.mTeam = mTeam;
    }
}
