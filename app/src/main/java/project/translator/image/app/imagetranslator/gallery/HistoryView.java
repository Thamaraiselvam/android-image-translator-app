package project.translator.image.app.imagetranslator.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import project.translator.image.app.imagetranslator.R;


public class HistoryView extends AppCompatActivity {
    private ListView listView;
    ExtraFunctions extraFunctions;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        extraFunctions = new ExtraFunctions();
        ArrayList<String> ar = extraFunctions.getProcessImagesFromDB(getApplicationContext());
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_single, ar);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}
