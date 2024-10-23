package devandroid.maddo.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.maddo.applistacurso.model.Pessoa;
import devandroid.maddo.applistacurso.view.MainActivity;

public class PessoaController {


    SharedPreferences preferences;
    SharedPreferences.Editor listavip;
    public static final String NOME_PREFERECES = "pref_listavip";


    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERECES, 0);
        listavip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC COnTROLLER", "controller iniciada");
        return super.toString();
    }


    public void salvar(Pessoa pessoa) {
        Log.d("MVC COnTROLLER", "salvo: " + pessoa.toString());
        listavip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listavip.putString("sobreNome", pessoa.getSobreNome());
        listavip.putString("nomeCurso", pessoa.getCursoDesejado());
        listavip.putString("telefoneContato", pessoa.getTelefoneContato());

        listavip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "Na"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "Na"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", "Na"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "Na"));

        return pessoa;
    }

    public void limpar() {
        listavip.clear();
        listavip.apply();
    }
}
