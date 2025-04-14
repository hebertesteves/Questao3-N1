package br.fecap.ads.questao3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacaoCadastroActivity extends AppCompatActivity {

    // Declaração dos elementos da interface (View)
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacao_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Instanciar os elementos e vincular ao id:
        textResultado = findViewById(R.id.textResultado);

        // Recebendo os dados da Tela que foram enviados pelo Intent:
        Bundle bundle = getIntent().getExtras();

        // Decomposição dos dados do objeto enviado:
        String nome = bundle.getString("nome");

        // Mostrar os dados:
        textResultado.setText(String.format("Seja bem-vindo, %s! Seu cadastro foi concluído com sucesso.", nome));

    }

    // Função para voltar para a Tela Inicial
    public void voltar(View view) {
        // Invoca a "MainActivity"
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}