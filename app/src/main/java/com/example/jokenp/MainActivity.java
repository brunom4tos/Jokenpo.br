package com.example.jokenp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view ){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view ){
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view ){
        this.opcaoSelecionada("Tesoura");
    }


    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.TextoResultado);

        int resultado = new Random().nextInt(3);//0 1 2
        String [] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes [ resultado ];

        switch ( escolhaApp ){
            case "Pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
            (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
            (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
            (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ){//App ganhador
            textoResultado.setText("Você perdeu!!");
        }else if(
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")

        ){//Usuario ganhador
            textoResultado.setText("Você ganhou!!");
        }else{//Empate
            textoResultado.setText("Empate!!");
        }

        System.out.println("Item clicado!" + escolhaApp );


    }


}