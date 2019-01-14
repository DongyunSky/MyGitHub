package `fun`.chaoxi.wing.module.lab

import `fun`.chaoxi.wing.R
import `fun`.chaoxi.wing.util.isGpsEnable
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lab_bluetooth.*
import org.jetbrains.anko.onClick
import java.util.*


/**
 * @author Wing Gao
 * @date 2019/1/2 11:25
 * @description 测试安卓的蓝牙模块
 *  Android提供蓝牙API来执行这些不同的操作。
 *  1. 扫描其他蓝牙设备
 *  2. 获取配对设备列表
 *  3. 连接到通过服务发现其他设备
 */
class TestBluetooth : AppCompatActivity() {
    val instance by lazy { this } //这里使用了委托，表示只有使用到instance才会执行该段代码
    // Android提供BluetoothAdapter类蓝牙通信。通过调用创建的对象的静态方法getDefaultAdapter()。
    // lateinit 表示需要延迟初始化并且不会为null
    private lateinit var bluetoothAdapter: BluetoothAdapter
    // 放附近蓝牙设备的列表
    private var bluetoothDeviceList = ArrayList<BluetoothDevice>()
    // 匿名类使用方法
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // 收到的广播类型
            val action = intent?.action
            when (action) {
                // 发现设备
                BluetoothDevice.ACTION_FOUND -> {
                    // 从intent中获取设备
                    val device: BluetoothDevice = intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                    // 如果当前设备未被绑定
                    if (device.bondState != BluetoothDevice.BOND_BONDED) {
                        // 添加到list中
                        if (!bluetoothDeviceList.contains(device)) bluetoothDeviceList.add(device)
                    }
                    showData()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_lab_bluetooth)

        // 初始化BluetoothAdapter
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        initView()
        initOnClick()
    }

    private fun initView() {
        // 初始化打开关闭按钮
        if (bluetoothAdapter.isEnabled) {
            turnBLUBtn.setText(R.string.turn_off_bluetooth)
        } else {
            turnBLUBtn.setText(R.string.turn_on_bluetooth)
        }
    }

    private fun initOnClick() {
        // 设置打开关闭蓝牙的事件
        turnBLUBtn.onClick { view ->
            if (bluetoothAdapter.isEnabled) {
                bluetoothAdapter.disable()
                turnBLUBtn.setText(R.string.turn_on_bluetooth)
                getDeviceList()
            } else {
                bluetoothAdapter.enable()
                turnBLUBtn.setText(R.string.turn_off_bluetooth)
                getDeviceList()
            }
        }
        // 设置开始扫描按钮的事件
        scanBLUDevice.onClick { getDeviceList() }
    }

    private fun getDeviceList() {
        // 注册异 步广播接受扫描到的设备
        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        registerReceiver(receiver, filter)

        // 开启扫描
        if (bluetoothAdapter.isDiscovering) {
            bluetoothAdapter.cancelDiscovery()
        }
        // 异步搜索附近设备
        bluetoothAdapter.startDiscovery()
    }

    /**
     * 展示数据
     */
    private fun showData() {
        // new Manager并设置给RecyclerView
        val manager = LinearLayoutManager(this)
        bluetoothDeviceRV.layoutManager = manager

        // 准备数据给Adapter List<BluetoothItem>
        val itemList = ArrayList<BluetoothItem>()
        for (device in bluetoothDeviceList) {
            val address = device.address
            itemList.add(BluetoothItem(address, address, address))
        }
        val adapter = BluetoothDeviceAdapter(this, itemList)
        bluetoothDeviceRV.adapter = adapter
    }

    /**
     * 获取本机蓝牙地址
     */
    private fun getLocalBluetoothAddress(): String? {
        isGpsEnable(this)
        return null
    }
}
