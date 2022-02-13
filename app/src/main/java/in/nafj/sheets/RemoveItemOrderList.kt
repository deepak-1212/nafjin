package `in`.nafj.sheets

import `in`.nafj.databinding.FragmentRemoveItemOrderListBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val TAG = "RemoveItemOrderList"
class RemoveItemOrderList(private val removeItemInterface: RemoveItemInterface) : BottomSheetDialogFragment() {

    interface RemoveItemInterface {
        fun onRemoveSelected()
        fun onRemoveCancelled()
    }

    private lateinit var binding: FragmentRemoveItemOrderListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentRemoveItemOrderListBinding.inflate(inflater, container, false)

        binding.cancelRemoveItem.setOnClickListener {
            dismiss()
            removeItemInterface.onRemoveCancelled()
        }

        binding.okRemoveItem.setOnClickListener {
            dismiss()
            removeItemInterface.onRemoveSelected()
        }

        return binding.root

    }

}