package br.edu.ifsp.scl.sdm.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private EditText email;
    private CheckBox listaEmail;
    private RadioButton sexo;
    private EditText cidade;
    private Spinner uf;
    private Button btnSalvar, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.editTextNome);
        telefone = (EditText) findViewById(R.id.editTextTelefone);
        email = (EditText) findViewById(R.id.editTextEmail);
        listaEmail = (CheckBox) findViewById(R.id.listaEmail);
        sexo = (RadioButton) findViewById(R.id.idFeminino);
        cidade = (EditText) findViewById(R.id.editTextCidade);
        uf = (Spinner) findViewById(R.id.spinnerUF);

        String[] itens = new String[]{"AC","AL","AP","AM","BA","CE","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR", "SC","SP","SE","TO","DF"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itens);

        uf.setAdapter(adapter);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome.setText("");
                telefone.setText("");
                email.setText("");
                listaEmail.setChecked(false);
                sexo.setChecked(false);
                cidade.setText("");
                uf.setSelection(0);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String resultado = "Nome: "+nome.getText().toString();
                resultado += "\nTelefone: " + telefone.getText().toString();
                resultado += "\nEmail: " + email.getText().toString();

                if(listaEmail.isChecked()){
                    resultado += "\nIngressar na lista de emails!";
                }else{
                    resultado += "\nNão ingressar na lista de emails!";
                }

                if(!sexo.isChecked()){
                    sexo = (RadioButton) findViewById(R.id.idMasculino);
                }

                resultado += "\nSexo: "+sexo.getText().toString();
                resultado += "\nCidade: "+cidade.getText().toString();
                int posicao = uf.getSelectedItemPosition();
                String estado = uf.getItemAtPosition(posicao).toString();
                resultado += "\nUF: "+estado;

                Toast.makeText(getApplicationContext() , resultado, Toast.LENGTH_SHORT).show();
            }
        });
    }

}