package `fun`.chaoxi.wing.module.lab

import `fun`.chaoxi.wing.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bluetooth_device.view.*
import java.util.*


/**
 * @author Wing Gao
 * @date 2019/1/2 16:26
 * @description 适配蓝牙扫描出的设备的列表
 */
class BluetoothDeviceAdapter(private val context: Context, data: List<BluetoothItem>) : RecyclerView.Adapter<BluetoothDeviceAdapter.ViewHolder>() {

    private var itemList: List<BluetoothItem>? = ArrayList()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 创建ViewHolder并返回
        return ViewHolder(inflater.inflate(R.layout.item_bluetooth_device, parent, false))
    }

    /**
     * 返回Item的个数
     * itemList是null的话“itemList?.size”返回null，“itemList?.size”是null的话返回0
     */
    override fun getItemCount(): Int = itemList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bluetoothItem = itemList?.get(position)
        holder.name.setText(bluetoothItem?.address)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.nameTextView
        var address: TextView = itemView.nameTextView
        var imgSrc: ImageView = itemView.logoImageView
    }
}
