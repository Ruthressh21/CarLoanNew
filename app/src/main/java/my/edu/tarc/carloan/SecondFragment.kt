package my.edu.tarc.carloan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import my.edu.tarc.carloan.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //_binding = FragmentSecondBinding.inflate(inflater,
        // container,
        // false)
        //TODO 4: Initialise Data Binding Class
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_second,
            container,
            false
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Enable menu handler line 20 - 29
        setHasOptionsMenu(true)

    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_about).isVisible = false
        menu.findItem(R.id.action_settings).isVisible = false

    //TODO 5: Create an instance of data set
        val interestDataSet = InterestDataSet(
            "CIMB\nMaybank\nPubic Bank\nRHB",
            "2.95%(p.a)\n2.99%(p.a)\n3.05%(p.a)\n3.10%(p.a)")

        //TODO 6: Connect data set to layout
        binding.interestDataSet = interestDataSet

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}