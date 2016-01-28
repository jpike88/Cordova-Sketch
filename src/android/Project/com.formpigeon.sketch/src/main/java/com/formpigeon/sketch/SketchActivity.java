package com.formpigeon.sketch;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;


public class SketchActivity extends AppCompatActivity {

    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;
    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Intent stampActivity = null;
    private CanvasView canvas     = null;
    private Handler mUiHandler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sketch_activity);

        this.canvas = (CanvasView)this.findViewById(R.id.canvas);
        stampActivity = new Intent(this, StampActivity.class);

        final FloatingActionMenu shapeMenu = (FloatingActionMenu) findViewById(R.id.shapeMenu);

        final FloatingActionButton undo = (FloatingActionButton) findViewById(R.id.undo);
        final FloatingActionButton redo = (FloatingActionButton) findViewById(R.id.redo);
        final FloatingActionButton clear = (FloatingActionButton) findViewById(R.id.clear);
        final FloatingActionButton text = (FloatingActionButton) findViewById(R.id.text);
        final FloatingActionButton stamp = (FloatingActionButton) findViewById(R.id.stamp);

        undo.setOnClickListener(clickListener);
        redo.setOnClickListener(clickListener);
        clear.setOnClickListener(clickListener);
        text.setOnClickListener(clickListener);
        stamp.setOnClickListener(clickListener);

        System.out.println(getIntent().getStringExtra("json"));
        shapeMenu.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shapeMenu.toggle(true);
            }
        });

        menus.add(shapeMenu);

        shapeMenu.hideMenuButton(false);


        int delay = 400;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }

        shapeMenu.setClosedOnTouchOutside(true);
        fab1 = (FloatingActionButton) findViewById(R.id.line);
        fab2 = (FloatingActionButton) findViewById(R.id.circle);
        fab3 = (FloatingActionButton) findViewById(R.id.rectangle);


        fab1.setOnClickListener(clickListener);
        fab2.setOnClickListener(clickListener);
        fab3.setOnClickListener(clickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

//    menu3.getMenuIconView().setImageResource(menu3.isOpened()
//    ? R.drawable.ic_close : R.drawable.ic_star);


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = "";
            final FloatingActionMenu shapeMenu = (FloatingActionMenu) findViewById(R.id.shapeMenu);


            int id =  v.getId();

                if(id == R.id.undo) {
                    canvas.undo();
                } else if(id == R.id.redo) {
                    canvas.redo();
                } else if(id == R.id.clear) {
                    canvas.clear();
                } else if(id == R.id.text) {
                    canvas.setText("test");
                    canvas.setMode(CanvasView.Mode.TEXT);
                } else if(id == R.id.stamp) {
                    startActivityForResult(stampActivity, 0);
                } else if(id == R.id.line) {
                    canvas.setText("");
                    canvas.setMode(CanvasView.Mode.DRAW);
                    canvas.setDrawer(CanvasView.Drawer.LINE);
                    shapeMenu.close(true);
                } else if(id == R.id.circle) {
                    canvas.setText("");
                    canvas.setMode(CanvasView.Mode.DRAW);
                    canvas.setDrawer(CanvasView.Drawer.ELLIPSE);
                    shapeMenu.close(true);
                } else if(id == R.id.rectangle) {
                    canvas.setText("");
                    canvas.setMode(CanvasView.Mode.DRAW);
                    canvas.setDrawer(CanvasView.Drawer.RECTANGLE);
                    shapeMenu.close(true);
                }




        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




    }
}


