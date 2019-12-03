package com.example.empresas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListaVaga extends BaseAdapter {


    private Context context;
    private List<Vaga> vagas;
    private LayoutInflater inflater;

    public AdapterListaVaga(Context context, List<Vaga> vagas) {
        this.context = context;
        this.vagas = vagas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return vagas.size();
    }

    @Override
    public Object getItem(int position) {
        return vagas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return vagas.get(position).getIdVaga();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.layout_item_vaga, null);
            item = new Suporte();

            item.tvNomeVaga = (TextView) convertView.findViewById(R.id.tvIdNomeVaga);
            //item.tvQtdProduto = (TextView) convertView.findViewById(R.id.tvQuantidaeProduto);
            item.tvSalario = (TextView) convertView.findViewById(R.id.tvSalario);
            item.tvIdVaga= (TextView) convertView.findViewById(R.id.tvIdVaga);
            convertView.setTag(item);

        } else {
            item = (Suporte) convertView.getTag();
        }

        Vaga prod = vagas.get(position);
        item.tvIdVaga.setText(String.valueOf(prod.getIdVaga()));
        item.tvNomeVaga.setText(prod.getNomeVaga());
        item.tvSalario.setText(String.valueOf(prod.getValorSalario()));


        return convertView;
    }

    private class Suporte {
        TextView tvNomeVaga, tvSalario, tvIdVaga;
    }

}
