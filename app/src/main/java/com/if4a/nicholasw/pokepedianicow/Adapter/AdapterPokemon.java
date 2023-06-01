package com.if4a.nicholasw.pokepedianicow.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if4a.nicholasw.pokepedianicow.API.APIRequestData;
import com.if4a.nicholasw.pokepedianicow.API.RetroServer;
import com.if4a.nicholasw.pokepedianicow.Activity.DetailActivity;
import com.if4a.nicholasw.pokepedianicow.Activity.MainActivity;
import com.if4a.nicholasw.pokepedianicow.Activity.UbahActivity;
import com.if4a.nicholasw.pokepedianicow.Model.ModelPokemon;
import com.if4a.nicholasw.pokepedianicow.Model.ModelResponse;
import com.if4a.nicholasw.pokepedianicow.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterPokemon
        extends RecyclerView.Adapter<AdapterPokemon.VHPokemon>
{

    private Context ctx;
    private List<ModelPokemon> listPokemon;

    public AdapterPokemon(Context ctx, List<ModelPokemon> listPokemon) {
        this.ctx = ctx;
        this.listPokemon = listPokemon;
    }

    @NonNull
    @Override
    public VHPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pokemon,

                parent, false);

        return new VHPokemon(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull VHPokemon holder, int position) {
        ModelPokemon MK = listPokemon.get(position);
        holder.tvId.setText(MK.getId());
        holder.tvName.setText((position+1) + "." + MK.getName());
        holder.tvEntry.setText(MK.getEntry());
        holder.tvType.setText(MK.getType());
        holder.tvAbility.setText(MK.getAbility());
        holder.tvHP.setText(MK.getHp());
        holder.tvATK.setText(MK.getAtk());
        holder.tvDEF.setText(MK.getDef());
        holder.tvSpA.setText(MK.getSpa());
        holder.tvSpD.setText(MK.getSpd());
        holder.tvSPE.setText(MK.getSpe());
        holder.tvMove1.setText(MK.getMove1());
        holder.tvMove2.setText(MK.getMove2());
        holder.tvMove3.setText(MK.getMove3());
        holder.tvMove4.setText(MK.getMove4());
        holder.tvNamaEvo.setText(MK.getNamaevo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             
                String Name = MK.getName();
                String Entry = MK.getEntry();
                String Type = MK.getType();
                String Ability = MK.getAbility();
                String HP = MK.getHp();
                String ATK = MK.getAtk();
                String DEF = MK.getDef();
                String SpA = MK.getSpa();
                String SpD = MK.getSpd();
                String SPE = MK.getSpe();
                String Move1 = MK.getMove1();
                String Move2 = MK.getMove2();
                String Move3 = MK.getMove3();
                String Move4 = MK.getMove4();
                String NamaEvo = MK.getNamaevo();

                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("varName", Name);
                intent.putExtra("varEntry", Entry);
                intent.putExtra("varType", Type);
                intent.putExtra("varAbility", Ability);
                intent.putExtra("varHp", HP);
                intent.putExtra("varAtk", ATK);
                intent.putExtra("varDef", DEF);
                intent.putExtra("varSpa", SpA);
                intent.putExtra("varSpd", SpD);
                intent.putExtra("varSpe", SPE);
                intent.putExtra("varMove1", Move1);
                intent.putExtra("varMove2", Move2);
                intent.putExtra("varMove3", Move3);
                intent.putExtra("varMove4", Move4);
                intent.putExtra("varNamaEvo", NamaEvo);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public class VHPokemon extends RecyclerView.ViewHolder
    {
        TextView tvId, tvName, tvEntry, tvType, tvAbility, tvHP, tvATK, tvDEF, tvSpA, tvSpD, tvSPE,
                tvMove1, tvMove2, tvMove3, tvMove4, tvNamaEvo;

        ImageView ivPokemon, ivEvo;
        public VHPokemon(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvEntry = itemView.findViewById(R.id.tv_entry);
            tvType = itemView.findViewById(R.id.tv_type);
            tvAbility = itemView.findViewById(R.id.tv_Ability);
            tvHP = itemView.findViewById(R.id.tv_HP);
            tvATK = itemView.findViewById(R.id.tv_ATK);
            tvDEF = itemView.findViewById(R.id.tv_DEF);
            tvSpA = itemView.findViewById(R.id.tv_SpA);
            tvSpD = itemView.findViewById(R.id.tv_SpD);
            tvSPE = itemView.findViewById(R.id.tv_SPE);
            tvMove1 = itemView.findViewById(R.id.tv_Move1);
            tvMove2 = itemView.findViewById(R.id.tv_Move2);
            tvMove3 = itemView.findViewById(R.id.tv_Move3);
            tvMove4 = itemView.findViewById(R.id.tv_Move4);
            tvNamaEvo = itemView.findViewById(R.id.tv_Evoname);
            ivPokemon = itemView.findViewById(R.id.iv_Pokemon);
            ivEvo = itemView.findViewById(R.id.iv_Evo);


//            ivEvo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(i, RESULT_LOAD_IMAGE);
//                }
//            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder pesan = new AlertDialog.Builder(ctx);
                    pesan.setTitle("perhatian");
                    pesan.setMessage("Operasi apa yang akan dilakukan?");
                    pesan.setCancelable(true);

                    pesan.setNegativeButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            hapusPokemon(tvId.getText().toString());
                            dialog.dismiss();
                        }
                    });

                    pesan.setPositiveButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent pindah = new Intent(ctx, UbahActivity.class);
                            pindah.putExtra("xId", tvId.getText().toString());
                            pindah.putExtra("xName", tvName.getText().toString());
                            pindah.putExtra("xEntry", tvEntry.getText().toString());
                            pindah.putExtra("xType", tvType.getText().toString());
                            pindah.putExtra("xAbility", tvAbility.getText().toString());
                            pindah.putExtra("xHP", tvHP.getText().toString());
                            pindah.putExtra("xATK", tvATK.getText().toString());
                            pindah.putExtra("xDEF", tvDEF.getText().toString());
                            pindah.putExtra("xSPA", tvSpA.getText().toString());
                            pindah.putExtra("xSPD", tvSpD.getText().toString());
                            pindah.putExtra("xSPE", tvSPE.getText().toString());
                            pindah.putExtra("xMove1", tvMove1.getText().toString());
                            pindah.putExtra("xMove2", tvMove2.getText().toString());
                            pindah.putExtra("xMove3", tvMove3.getText().toString());
                            pindah.putExtra("xMove4", tvMove4.getText().toString());
                            pindah.putExtra("xEvoName", tvNamaEvo.getText().toString());
                            ctx.startActivity(pindah);
                        }
                    });
                    pesan.show();
                    return false;
                }
            });

        }

//        private void chooseFotoPokemon()
//        {
//
//        }

        private void hapusPokemon(String idPokemon)
        {
            APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ModelResponse> proses = ARD.ardDelete(idPokemon);

            proses.enqueue(new Callback<ModelResponse>() {
                @Override
                public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                    String kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    Toast.makeText(ctx, "Kode: " + kode + ", Pesan: " + pesan, Toast.LENGTH_SHORT).show();
                    ((MainActivity) ctx).retrievePokemon();
                }

                @Override
                public void onFailure(Call<ModelResponse> call, Throwable t) {

                }
            });


        }

    }

}

