package hoangviet.ndhv.demoui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
private TextView txtPhepTinh,txtKetQua;
private Button btnOK;
public static final String Data = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        int result;
        txtPhepTinh = (TextView)findViewById(R.id.txtPhepTinh);
        txtKetQua = (TextView)findViewById(R.id.txtResultSecond);
        btnOK = (Button)findViewById(R.id.btnOK);
        final Bundle bundle = getIntent().getBundleExtra("bundle");
        final int soA = bundle.getInt("soA");
        final int soB = bundle.getInt("soB");
        final String phepTinh = bundle.getString("phepTinh");
        switch (phepTinh){
            case "+" :
                result = soA + soB;
                txtPhepTinh.setText(soA + " + " +soB);
                txtKetQua.setText(result + "");
                bundle.putInt("result",result);
                break;
            case "-" :
                result = soA - soB;
                txtPhepTinh.setText(soA + " - " +soB);
                txtKetQua.setText(result + "");
                bundle.putInt("result",result);
                break;
            case "x" :
                result = soA * soB;
                txtPhepTinh.setText(soA + " x " +soB);
                txtKetQua.setText(result + "");
                bundle.putInt("result",result);
                break;
            case ":" :
                result = (soA / soB);
                txtPhepTinh.setText(soA + " : " +soB);
                txtKetQua.setText(result + "");
                bundle.putInt("result",result);
                break;

        }
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(Data,bundle);
                setResult(CalculatorActivity.RESULT_OK,data);
                finish();
            }
        });

    }
}
