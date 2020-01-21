package com.example.u1tema3bottonnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

  Fragment FragmentoSeleccionado = null;
  FragmentManager fragmentManager = getSupportFragmentManager();
  FragmentTransaction transaction = fragmentManager.beginTransaction();



  private ActionBar toolbar;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar = getSupportActionBar();
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    toolbar.setTitle("Shop");



    FragmentoSeleccionado = new ListaFragmento();
    transaction.replace(R.id.frame_container,FragmentoSeleccionado);
    transaction.commit();




  }
  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
          = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      Fragment fragment;
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      switch (item.getItemId()) {
        case R.id.navigation_shop:

          toolbar.setTitle("Shop");

          FragmentoSeleccionado = new ListaFragmento();

          transaction.replace(R.id.frame_container,FragmentoSeleccionado);
          transaction.commit();
          return true;

        case R.id.navigation_gifts:
          toolbar.setTitle("My Gifts");
          FragmentoSeleccionado = new GridFragment();


          transaction.replace(R.id.frame_container,FragmentoSeleccionado);
          transaction.commit();
          return true;

        case R.id.navigation_cart:
          toolbar.setTitle("Cart");

          FragmentoSeleccionado = new CuentaFragmento ();

          transaction.replace(R.id.frame_container,FragmentoSeleccionado);
          transaction.commit();


          return true;

        case R.id.navigation_profile:
          toolbar.setTitle("Profile");

          FragmentoSeleccionado = new LoginFragmento ();

          transaction.replace(R.id.frame_container,FragmentoSeleccionado);
          transaction.commit();
          return true;
      }
      return false;
    }
  };

  public void ButtonIzquierda(View view) {
    Snackbar.make(view, "Replace with your own action",
            Snackbar.LENGTH_LONG).setAction("Action", null).show();

  }

  public void ButtonDerecha(View view) {
    Toast.makeText(this, "Se pulso el floating button de la Derecha "+ view.getTag(), Toast.LENGTH_LONG).show();

  }
}
