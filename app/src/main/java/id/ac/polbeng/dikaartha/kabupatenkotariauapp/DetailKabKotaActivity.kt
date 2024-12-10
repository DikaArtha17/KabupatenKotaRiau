package id.ac.polbeng.dikaartha.kabupatenkotariauapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.bumptech.glide.Glide
import id.ac.polbeng.dikaartha.kabupatenkotariauapp.databinding.ActivityDetailKabKotaBinding

class DetailKabKotaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKabKotaBinding
    companion object {
        const val EXTRA_KAB_KOTA = "extra_kab_kota"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKabKotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val dataKabKota = intent.getParcelableExtra<KabKota>(EXTRA_KAB_KOTA) as KabKota
        Glide.with(applicationContext)
            .load(dataKabKota.gambar)
            .into(binding.imgItemPhoto)
        binding.tvNama.text = dataKabKota.kabupaten_kota
        binding.tvPusatPemerintahan.text = dataKabKota.pusat_pemerintahan
        binding.tvBupatiWalikota.text = dataKabKota.bupati_walikota
        binding.tvLuasWilayah.text = dataKabKota.luas_wilayah.toString()
        binding.tvJumlahPenduduk.text = dataKabKota.jumlah_penduduk.toString()
        binding.tvJumlahKecamatan.text = dataKabKota.jumlah_kecamatan.toString()
        binding.tvJumlahKelurahan.text = dataKabKota.jumlah_kelurahan.toString()
        binding.tvJumlahDesa.text = dataKabKota.jumlah_desa.toString()
        binding.btnViewPeta.setOnClickListener {
            val showViewPeta = Intent(this@DetailKabKotaActivity, ViewPetaActivity::class.java)
            showViewPeta.putExtra(ViewPetaActivity.EXTRA_URL_PETA, dataKabKota.url_peta_wilayah)
            startActivity(showViewPeta)
        }
    }
}