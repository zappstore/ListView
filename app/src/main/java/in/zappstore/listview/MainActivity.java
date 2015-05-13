package in.zappstore.listview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    ListView listView;
    String[] title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.list_item);

        Resources resources=getResources();
        title=resources.getStringArray(R.array.title);
        CustomAdapter adapter=new CustomAdapter(this,title);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(getApplicationContext(),"clicked one",Toast.LENGTH_SHORT).show();
                }else if(position==1){
                    Toast.makeText(getApplicationContext(),"clicked two",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                }else if(position==2){
                    Toast.makeText(getApplicationContext(),"clicked three",Toast.LENGTH_SHORT).show();
                }else if(position==3){
                    Toast.makeText(getApplicationContext(),"clicked four",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class CustomAdapter extends ArrayAdapter<String>{
        Context context;
        String[] titleArray;
        CustomAdapter(Context c,String[] title ){

            super(c,R.layout.mylist,R.id.text,title);
            this.context=c;
            this.titleArray=title;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.mylist,parent,false);
            TextView textView= (TextView) row.findViewById(R.id.text);
            textView.setText(titleArray[position]);
            return row;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
