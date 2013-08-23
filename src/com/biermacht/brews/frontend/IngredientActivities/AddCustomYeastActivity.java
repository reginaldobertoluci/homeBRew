package com.biermacht.brews.frontend.IngredientActivities;

import android.os.Bundle;

import com.biermacht.brews.utils.Constants;
import com.biermacht.brews.utils.Database;

public class AddCustomYeastActivity extends AddYeastActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Remove views we don't want
        mainView.removeView(amountView);
    }

    @Override
    public void onFinished()
    {
        Database.addIngredientToVirtualDatabase(Constants.DATABASE_CUSTOM, yeast, Constants.MASTER_RECIPE_ID);
        finish();
    }

    @Override
    public void acquireValues() throws Exception
    {
        super.acquireValues();

        yeast.setShortDescription("Custom yeast");
    }
}
