package br.fecap.ads.questao3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioCadastroActivity extends AppCompatActivity {

    // Declaração dos elementos da interface (View)
    private EditText campoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Função para cadastrar o nome do cliente
    public void cadastrar(View view) {

        // Vinculando os elementos com os Views
        campoNome = findViewById(R.id.txtNome);

        // Variaveis para recuperar (get) e converter em String:
        String nome = campoNome.getText().toString();;

        // Verifica se o campo de nome está vazio, caso esteja ele vai usar um return para o usuario não prosseguir sem digitar
        if (nome.isEmpty()) {
            campoNome.setError("Informe seu nome");
            campoNome.requestFocus(); // Coloca o foco no campo para o usuário digitar
            return;
        }

        // Invoca a "ConfirmacaoCadastroActivity"
        Intent intent = new Intent(this, ConfirmacaoCadastroActivity.class);

        // Adicionar parametros para outra Activity:
        intent.putExtra("nome", nome);

        startActivity(intent);

    }
}