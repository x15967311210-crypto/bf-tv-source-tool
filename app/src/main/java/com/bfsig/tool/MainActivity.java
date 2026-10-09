package com.bfsig.tool;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // 暴风信号源服务监听的广播（真正触发“信号源”列表）
    private static final String ACTION_SOURCE_SWITCH = "baofengtv.action.SOURCE_SWITCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.parseColor("#111111"));
        root.setPadding(90, 70, 90, 70);

        TextView title = new TextView(this);
        title.setText("信号源 / HDMI 工具");
        title.setTextColor(Color.WHITE);
        title.setTextSize(26);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        root.addView(makeButton("① 信号源 / 输入源（切换）",
                null, null, ACTION_SOURCE_SWITCH));
        root.addView(makeButton("② 打开 HDMI / 电视画面",
                "com.baofengtv.tvplayer", "com.baofengtv.tvplayer.MainActivity", null));
        root.addView(makeButton("③ 系统设置",
                "com.baofengtv.settings", "com.baofengtv.settings.MainActivity", null));

        setContentView(root);
    }

    private Button makeButton(String text, final String pkg, final String cls, final String action) {
        Button b = new Button(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 26, 0, 0);
        b.setLayoutParams(lp);
        b.setText(text);
        b.setTextSize(20);
        b.setAllCaps(false);
        b.setOnClickListener(v -> {
            try {
                if (action != null) {
                    sendBroadcast(new Intent(action));
                    Toast.makeText(MainActivity.this, "已触发信号源", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent();
                    i.setClassName(pkg, cls);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                }
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "失败：" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return b;
    }
}
