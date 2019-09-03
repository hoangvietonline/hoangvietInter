package hoangviet.ndhv.demoui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_CALCULATOR = 12;
    private EditText edtSoA;
    private EditText edtSoB;
    private Button btnAdd,btnMul,btnSub,btnDev;
    private TextView txtResult;
    private int result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        edtSoA = (EditText)findViewById(R.id.edtSoA);
        edtSoB = (EditText)findViewById(R.id.edtSoB);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDev = (Button)findViewById(R.id.btnDev);
        txtResult = (TextView)findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("soA",Integer.valueOf(edtSoA.getText().toString()));
                bundle.putInt("soB",Integer.valueOf(edtSoB.getText().toString()));
                bundle.putString("phepTinh","+");
                intent.putExtra("bundle",bundle);
                startActivityForResult(intent,REQUEST_CODE_CALCULATOR);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("soA",Integer.valueOf(edtSoA.getText().toString()));
                bundle.putInt("soB",Integer.valueOf(edtSoB.getText().toString()));
                bundle.putString("phepTinh","-");
                intent.putExtra("bundle",bundle);
                startActivityForResult(intent,REQUEST_CODE_CALCULATOR);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("soA",Integer.valueOf(edtSoA.getText().toString()));
                bundle.putInt("soB",Integer.valueOf(edtSoB.getText().toString()));
                bundle.putString("phepTinh","x");
                intent.putExtra("bundle",bundle);
                startActivityForResult(intent,REQUEST_CODE_CALCULATOR);
            }
        });
        btnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("soA",Integer.valueOf(edtSoA.getText().toString()));
                bundle.putInt("soB",Integer.valueOf(edtSoB.getText().toString()));
                bundle.putString("phepTinh",":");
                intent.putExtra("bundle",bundle);
                startActivityForResult(intent,REQUEST_CODE_CALCULATOR);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case REQUEST_CODE_CALCULATOR:
                if (resultCode == RESULT_OK && data != null){
                    Bundle bundle = data.getBundleExtra(SecondActivity.Data);
                    int a = bundle.getInt("soA");
                    int b = bundle.getInt("soB");
                    int result = bundle.getInt("result");
                    String pt = bundle.getString("phepTinh");
                    txtResult.setText(a + " "+ pt + " " + b + " = " + result);
                }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
