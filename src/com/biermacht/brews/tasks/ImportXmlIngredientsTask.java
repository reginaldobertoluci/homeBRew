package com.biermacht.brews.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.biermacht.brews.frontend.MainActivity;

public class ImportXmlIngredientsTask extends AsyncTask<String, Void, String> {

    private Context context;
    private ProgressDialog progress;

    public ImportXmlIngredientsTask(Context c)
    {
        super();
        this.context = c;
    }

    @Override
    protected String doInBackground(String... params)
    {
        // Grab ingredients from xml, put them into SQLite
        MainActivity.ingredientHandler.ImportIngredientAssets();
        return "Executed";
    }

    @Override
    protected void onPostExecute(String result)
    {
        super.onPostExecute(result);
        progress.dismiss();
        Log.d("ImportXmlIngredients", "Finished importing assets");
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        progress = new ProgressDialog(context);
        progress.setMessage("Performing first use database setup");
        progress.setIndeterminate(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCancelable(true);
        progress.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}