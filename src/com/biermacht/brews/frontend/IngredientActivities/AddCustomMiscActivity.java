package com.biermacht.brews.frontend.IngredientActivities;

import android.os.Bundle;

import com.biermacht.brews.utils.Constants;
import com.biermacht.brews.utils.Database;

public class AddCustomMiscActivity extends AddMiscActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Remove views we don't want
        mainView.removeView(timeView);
        mainView.removeView(amountView);
    }

    @Override
    public void acquireValues() throws Exception
    {
        super.acquireValues();
        misc.setShortDescription("Custom misc");
        misc.setUseFor("Custom");
    }

    @Override
    public void onFinished()
    {
        Database.addIngredientToVirtualDatabase(Constants.DATABASE_CUSTOM, misc, Constants.MASTER_RECIPE_ID);
        finish();
    }

}
