package com.sd.www.poper;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sd.lib.poper.Poper;
import com.sd.lib.poper.layouter.CombineLayouter;
import com.sd.lib.poper.layouter.DefaultLayouter;
import com.sd.lib.poper.layouter.FixBoundaryLayouter;
import com.sd.lib.utils.FViewUtil;

/**
 * Created by Administrator on 2018/1/10.
 */
public class AutoActivity extends AppCompatActivity
{
    private Button btn_big;
    private Button btn_small;

    private Button btn_pop;

    private TestPopView mPopView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_auto);
        btn_big = findViewById(R.id.btn_big);
        btn_small = findViewById(R.id.btn_small);
        btn_pop = findViewById(R.id.btn_pop);

        btn_big.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FViewUtil.setSize(btn_pop, btn_pop.getWidth() + 100, btn_pop.getHeight() + 100);
            }
        });
        btn_small.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FViewUtil.setSize(btn_pop, btn_pop.getWidth() - 100, btn_pop.getHeight() - 100);
            }
        });

        btn_pop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getPopView().getPoper().attach(!getPopView().getPoper().isAttached());
            }
        });
    }

    public TestPopView getPopView()
    {
        if (mPopView == null)
        {
            mPopView = new TestPopView(this);
            mPopView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mPopView.getPoper()
                    .setTarget(btn_pop)
                    .setMarginY(new Poper.Margin()
                    {
                        @Override
                        public int getMargin()
                        {
                            return mPopView.getHeight();
                        }
                    })
                    .setLayouter(new CombineLayouter(new DefaultLayouter(), new FixBoundaryLayouter(FixBoundaryLayouter.Boundary.Height).setDebug(true)))
                    .setPosition(Poper.Position.Bottom);
        }
        return mPopView;
    }
}
