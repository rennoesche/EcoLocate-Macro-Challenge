package org.ecogank.ecolocate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.ecogank.ecolocate.Adapter.BacaanBerandaAdapter
import org.ecogank.ecolocate.Adapter.TPSTerdekatAdapter
import org.ecogank.ecolocate.Model.BacaanBeranda
import org.ecogank.ecolocate.Model.TPSTerdekatData

class BerandaFragment : Fragment() {
    // TODO: Rename and change types of parameters

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Standard Bottom Sheet TPS Terdekat
        val screenHeight = resources.displayMetrics.heightPixels
        val standardBottomSheet : LinearLayout = view.findViewById(R.id.standard_bottom_sheet)
        val standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)


        standardBottomSheetBehavior.peekHeight = screenHeight /4
        standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        // Recycler View Bacaan Beranda
        val bacaanBerandaRV : RecyclerView = view.findViewById(R.id.rv_bacaan_beranda)
        bacaanBerandaRV.setHasFixedSize(true)
        bacaanBerandaRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val bacaanBerandaList = ArrayList<BacaanBeranda>()

        bacaanBerandaList.add(BacaanBeranda(R.drawable.img_bacaanberanda01, "Kenali jenis-jenis TPS yang ada di Indonesia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sem purus, dapibus sit amet malesuada eget, eleifend at augue. Vestibulum vestibulum mauris eros, vel tincidunt ante placerat ut. Sed eget velit a ex accumsan suscipit in non risus. Nam urna purus, efficitur quis metus vel, pretium tempor felis. Sed feugiat risus velit, sagittis ullamcorper arcu consequat eu. Proin laoreet quam neque, id tempor nibh sollicitudin vel. Curabitur in elementum lectus, vel mattis mi. Vestibulum metus enim, interdum in porttitor sit amet, porttitor non nisl. Vestibulum non laoreet elit. Curabitur eu varius diam. Aliquam laoreet sapien a venenatis eleifend. Phasellus facilisis at metus sed dignissim. Nam enim erat, dignissim at nulla non, vulputate consectetur elit. Donec vitae posuere ipsum, quis elementum arcu. Quisque vitae enim in urna congue volutpat quis a turpis. Proin consectetur, tellus ac ullamcorper sollicitudin, leo diam vehicula mi, non laoreet dui velit vitae felis. Pellentesque sodales libero in tortor hendrerit, ac bibendum mi dapibus. Maecenas feugiat massa nec suscipit venenatis. Aenean vulputate dolor elit, eu finibus nulla condimentum non. Donec eget turpis placerat, cursus elit ut, auctor magna. Pellentesque ac massa bibendum elit consequat gravida. Aenean tellus sapien, vestibulum id lacus nec, fermentum volutpat risus. Donec finibus dui a dignissim dignissim. Morbi ante lorem, finibus in lobortis at, molestie et leo. Vestibulum in sodales est. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ultricies gravida risus, at ultrices mi dictum vel. Cras nulla mi, tempor semper augue id, volutpat gravida dolor. Cras consectetur laoreet nisi, ut maximus mauris convallis at. Ut vel risus fermentum, vulputate metus vel, fringilla enim. Suspendisse nec augue ligula. Fusce commodo nisl sed neque auctor, non tincidunt turpis tincidunt. Pellentesque hendrerit risus quis nibh hendrerit feugiat. Vivamus auctor justo justo, ut iaculis neque commodo eget. Proin convallis rhoncus arcu nec pretium. Curabitur quis nisl dolor. Suspendisse vel pellentesque neque. Nam quis fermentum metus. In placerat dolor ac neque pellentesque sodales. Suspendisse ornare sed neque pretium lobortis. Cras quis libero a velit tincidunt pharetra. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ultrices vel ex at molestie."))
        bacaanBerandaList.add(BacaanBeranda(R.drawable.img_bacaanberanda01, "Kenali jenis-jenis TPS yang ada di Amerika", "dhfgdfgdfgdjfbdjfbdhbfhdfdhfhdfhdgfhdgfedhfgdhgfdgfdhgfdhgfdjkgfdjkfgdfhdgfdhf"))
        bacaanBerandaList.add(BacaanBeranda(R.drawable.img_bacaanberanda01, "Kenali jenis-jenis TPS yang ada di Indonesia", "dhfgdfgdfgdjfbdjfbdhbfhdfdhfhdfhdgfhdgfedhfgdhgfdgfdhgfdhgfdjkgfdjkfgdfhdgfdhf"))
        bacaanBerandaList.add(BacaanBeranda(R.drawable.img_bacaanberanda01, "Kenali jenis-jenis TPS yang ada di Indonesia", "dhfgdfgdfgdjfbdjfbdhbfhdfdhfhdfhdgfhdgfedhfgdhgfdgfdhgfdhgfdjkgfdjkfgdfhdgfdhf"))

        val bacaanBerandaAdapter = BacaanBerandaAdapter(bacaanBerandaList)
        bacaanBerandaRV.adapter = bacaanBerandaAdapter

        bacaanBerandaAdapter.onItemClick = { clickedBacaan ->
            val intent = Intent(requireContext(), DetailBacaanBerandaActivity::class.java)
            intent.putExtra("bacaanberanda", clickedBacaan)
            startActivity(intent)
        }

        // Recycler View TPS Terdekat inside Bottom Sheet
        val tpsTerdekatBerandaRV : RecyclerView = view.findViewById(R.id.rv_tps_terdekat)
        tpsTerdekatBerandaRV.setHasFixedSize(true)
        tpsTerdekatBerandaRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val tpsTerdekatList = ArrayList<TPSTerdekatData>()

        tpsTerdekatList.add(TPSTerdekatData(R.drawable.img_bacaanberanda01, "TPS 3R Kalidoni", "TPS 3R", "Jalan Taqwa", "07.00 - 10.00", "Senin - Jum'at", "089646573222", "xxxxxx@email.com", 1.20, 2.20))
        tpsTerdekatList.add(TPSTerdekatData(R.drawable.img_bacaanberanda01, "TPS 3R Kalidoni", "TPS 3R", "Jalan Taqwa", "07.00 - 10.00", "Senin - Jum'at", "089646573222", "xxxxxx@email.com", 1.20, 2.20))
        tpsTerdekatList.add(TPSTerdekatData(R.drawable.img_bacaanberanda01, "TPS 3R Kalidoni", "TPS 3R", "Jalan Taqwa", "07.00 - 10.00", "Senin - Jum'at", "089646573222", "xxxxxx@email.com", 1.20, 2.20))
        tpsTerdekatList.add(TPSTerdekatData(R.drawable.img_bacaanberanda01, "TPS 3R Kalidoni", "TPS 3R", "Jalan Taqwa", "07.00 - 10.00", "Senin - Jum'at", "089646573222", "xxxxxx@email.com", 1.20, 2.20))
        tpsTerdekatList.add(TPSTerdekatData(R.drawable.img_bacaanberanda01, "TPS 3R Kalidoni", "TPS 3R", "Jalan Taqwa", "07.00 - 10.00", "Senin - Jum'at", "089646573222", "xxxxxx@email.com", 1.20, 2.20))

        val tpsTerdekatAdapter = TPSTerdekatAdapter(tpsTerdekatList)
        tpsTerdekatBerandaRV.adapter = tpsTerdekatAdapter
    }
}