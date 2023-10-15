package ma.ensa.recycleview;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.recycleview.R;
import ma.ensa.recycleview.adapter.StarAdapter;
import ma.ensa.recycleview.beans.Star;
import ma.ensa.recycleview.service.StarService;

public class ListActivity extends AppCompatActivity {
    private List<Star> stars;
    StarAdapter starAdapter = null;
    private RecyclerView recyclerView;
    private StarService service;

    //private StatefulAdapter starAdapter = null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        //insérer le code
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (starAdapter != null){
                    starAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        return true;
    }

      public void init(){
        service.create(new Star("kate bosworth", "http://www.starsphotos.com/resize.php?id=801", 3.5f));
        service.create(new Star("george clooney", "http://www.starsphotos.com/resize.php?id=1191", 3));
        service.create(new Star("michelle rodriguez",
                "http://www.starsphotos.com/resize.php?id=1120", 5));
        service.create(new Star("george clooney", "http://www.starsphotos.com/resize.php?id=1193", 1));
        service.create(new Star("louise bouroin", "http://www.starsphotos.com/resize.php?id=1185", 5));
        service.create(new Star("louise bouroin", "http://www.starsphotos.com/resize.php?id=1184", 1));
    }
}
