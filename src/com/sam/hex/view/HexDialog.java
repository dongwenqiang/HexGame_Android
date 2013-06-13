package com.sam.hex.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.sam.hex.PurchaseActivity;

public abstract class HexDialog extends PurchaseActivity {
    private HexDialogView view;

    private Context context;

    public HexDialog(Context context) {
        this.context = context;
    }

    public HexDialog() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        view = new HexDialogView(this, this);
        view.setBackgroundResource(android.R.color.transparent);

        setContentView(view);

        HexDialogView.Button positive = view.getButtons()[2];
        HexDialogView.Button negative = view.getButtons()[0];
        HexDialogView.Button neutral = view.getButtons()[1];

        positive.setView(getPositiveView());
        negative.setView(getNegativeView());
        neutral.setView(getNeutralView());

        positive.setOnClickListener(getPositiveOnClickListener());
        negative.setOnClickListener(getNegativeOnClickListener());
        neutral.setOnClickListener(getNeutralOnClickListener());
    }

    public abstract View getPositiveView();

    public abstract HexDialogView.Button.OnClickListener getPositiveOnClickListener();

    public abstract View getNegativeView();

    public abstract HexDialogView.Button.OnClickListener getNegativeOnClickListener();

    public abstract View getNeutralView();

    public abstract HexDialogView.Button.OnClickListener getNeutralOnClickListener();

    public void dismiss() {
        finish();
    }

    public void show() {
        context.startActivity(new Intent(context, this.getClass()));
    }
}
