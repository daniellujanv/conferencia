package conftec.daniel.daniellujanapps.conferenciatec;

import android.app.Application;

import com.flybits.core.api.Flybits;
import com.flybits.core.api.FlybitsOptions;

/**
 * Created by DanielLujanApps on domingo06/11/16.
 *
 */

public class ConferenciaTECApplication extends Application {

    @Override
    public void onCreate() {
        FlybitsOptions builder = new FlybitsOptions.Builder(this)
                //Additional Options Can Be Added Here
                .build();

        //Initialize the FlybitsOptions
        Flybits.include(this).initialize(builder);
    }

}
