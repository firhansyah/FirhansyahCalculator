package id.co.firhansyah.firhansyahcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText iptNumber1, iptNumber2;
    private Button btnTambah, btnKurang, btnKali, btnBagi;
    private ListView lvResult;

    private ArrayAdapter<String> adapter;
    private List<String> lResult;

    protected String sAngka1, sAngka2, operator;
    protected float angka1, angka2, hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    private void initComponent() {
        iptNumber1 = (EditText) findViewById(R.id.iptNumber1);
        iptNumber2 = (EditText) findViewById(R.id.iptNumber2);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(this);
        btnKurang = (Button) findViewById(R.id.btnKurang);
        btnKurang.setOnClickListener(this);
        btnKali = (Button) findViewById(R.id.btnKali);
        btnKali.setOnClickListener(this);
        btnBagi = (Button) findViewById(R.id.btnBagi);
        btnBagi.setOnClickListener(this);
        lvResult = (ListView) findViewById(R.id.lvResult);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvResult.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        lResult = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        sAngka1 = iptNumber1.getText().toString();
        sAngka2 = iptNumber2.getText().toString();

        if (sAngka1.isEmpty() || sAngka2.isEmpty()) {
            Toast.makeText(MainActivity.this, "Number 1 and Number 2 Cannot be Empty", Toast.LENGTH_SHORT).show();
            return;
        }

        angka1 = Float.parseFloat(sAngka1);
        angka2 = Float.parseFloat(sAngka2);

        switch (view.getId()) {
            case R.id.btnTambah:
                hasil = angka1 + angka2;
                operator = "+";
                break;

            case R.id.btnKurang:
                hasil = angka1 - angka2;
                operator = "-";
                break;

            case R.id.btnKali:
                hasil = angka1 * angka2;
                operator = "*";
                break;

            case R.id.btnBagi:
                hasil = angka1 / angka2;
                operator = "/";
                break;
        }

        lResult.add(0, sAngka1 + " " + operator + " " + sAngka2 + "  = " + Float.toString(hasil));
        adapter.clear();
        adapter.addAll(lResult);
    }
}
