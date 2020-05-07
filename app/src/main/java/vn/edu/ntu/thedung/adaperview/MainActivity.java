package vn.edu.ntu.thedung.adaperview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView HienThi;
    ListView lvTinhThanh;
    String [] arrayTinhThanh;
    String [] arrayThuNgay;
    ArrayAdapter<String> adapterTinhThanh;
    ArrayAdapter<String> adapterThuNgay;
    AutoCompleteTextView acTextView;
    Spinner spThuNgay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addViews(){
        lvTinhThanh = findViewById(R.id.danhsachtinh);
        arrayTinhThanh = getResources().getStringArray(R.array.tinh_thanh);
        adapterTinhThanh = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayTinhThanh);
        lvTinhThanh.setAdapter(adapterTinhThanh);

        acTextView = findViewById(R.id.acTextView);
        acTextView.setAdapter(adapterTinhThanh);
        acTextView.setThreshold(1);


        spThuNgay = findViewById(R.id.spThuNgay);
        arrayThuNgay = getResources().getStringArray(R.array.thu_ngay);
        adapterThuNgay = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayThuNgay);

        spThuNgay.setAdapter(adapterThuNgay);

        HienThi = findViewById(R.id.HienThi);




    }

    private void addEvents(){
        lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message = adapterTinhThanh.getItem(position);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });

        spThuNgay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String message = adapterThuNgay.getItem(position);
                HienThi.setText(message);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }
}
