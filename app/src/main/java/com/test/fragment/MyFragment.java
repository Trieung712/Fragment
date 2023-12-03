package com.test.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class MyFragment extends Fragment {

    private ArrayList<SanPham> sanPhams;
    private MyClickListener clickListener;
    private TextView textView;

    public interface MyClickListener {
        public void click(SanPham sanPham);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, null);

        sanPhams = new ArrayList<>();
        SanPham sanPham0 = new SanPham("CoCa-CoLa", "Giá: 165.000/thùng",
                " Bảo hành: 12 tháng. \r\n Nguồn gốc: Chính hãng. \r\n Hãng sản xuất: " +
                        "CoCa-CoLa. \r\n Dung tích(ml)/lon: 330. \r\n Xuất xứ: Việt Nam ",
                R.drawable.cocacola, 1);
        SanPham sanPham1 = new SanPham("Pepsi", "Giá: 160.000/thùng",
                " Bảo hành: 12 tháng. \r\n Nguồn gốc: Chính hãng. \r\n Hãng sản xuất: " +
                        "Pepsi. \r\n Dung tích(ml)/lon: 330. \r\n Xuất xứ: Việt Nam ",
                R.drawable.pepsi, 1);

        SanPham sanPham2 = new SanPham("Sữa đậu nành", "Giá: 140.000/thùng",
                " Bảo hành: 6 tháng. \r\n Nguồn gốc: Chính hãng. \r\n Hãng sản xuất: " +
                        "Milk. \r\n Dung tích(ml)/lon: 440. \r\n Xuất xứ: Việt Nam ",
                R.drawable.suadaunanh, 2);

        SanPham sanPham3 = new SanPham("7up", "Giá: 155.000/thùng",
                " Bảo hành: 12 tháng. \r\n Nguồn gốc: Chính hãng. \r\n Hãng sản xuất: " +
                        "7up. \r\n Dung tích(ml)/lon: 330. \r\n Xuất xứ: Việt Nam ",
                R.drawable.svup, 1);
        SanPham sanPham4 = new SanPham("Triệu+Khoa", "20200373+20200233",
                " Bảo hành: không. \r\n Nguồn gốc: Chính hãng. \r\n Hãng sản xuất: " +
                        "Human. \r\n Xuất xứ: Việt Nam ",
                R.drawable.me, 1);

        sanPhams.add(sanPham0);
        sanPhams.add(sanPham1);
        sanPhams.add(sanPham2);
        sanPhams.add(sanPham3);
        sanPhams.add(sanPham4);

        ListView listView = (ListView) view.findViewById(R.id.listView1);
        textView = (TextView) view.findViewById(R.id.textView1);

        listView.setAdapter(new AdapterListView(getActivity(), sanPhams));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (textView == null) {
                    clickListener = (MyClickListener) getActivity();
                    clickListener.click(sanPhams.get(position));
                } else {
                    textView.setText(sanPhams.get(position).getDescription() + "");
                }
            }
        });
        return view;

    }
}
