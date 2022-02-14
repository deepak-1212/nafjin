package `in`.nafj.sheets

import `in`.nafj.activity.ViewCartActivity
import `in`.nafj.activity.ViewCartDataModel
import `in`.nafj.databinding.FragmentRemoveItemOrderListBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val TAG = "RemoveItemOrderList"
class RemoveItemOrderList(
    private val removeItemInterface: ViewCartActivity.RemoveItemInterface,
    private val position: Int,
    private val viewCartDataModel: ViewCartDataModel
) : BottomSheetDialogFragment() {

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
            removeItemInterface.onRemoveSelected(position, viewCartDataModel)
        }

        return binding.root

    }

}