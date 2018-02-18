package kien.dhbkhn.tools.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import kien.dhbkhn.tools.R;

/**
 * Created by KienDepTrai on 12/02/2018.
 */

public class KienRecyclerView extends RecyclerView {

    private boolean isFixedSize = true;

    private boolean isLLMHorizontal = false;

    private boolean isLLMVertical = false; // default has vertical offset linear layout

    private boolean isGLMHorizontal = false;

    private boolean isGLMVertical = false;

    private int columnsGLM = 1; // default

    public KienRecyclerView(Context context) {
        super(context);
        setup(context);
    }

    public KienRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.KienRecyclerView);

        this.isFixedSize = typedArray.getBoolean(R.styleable.KienRecyclerView_nkien_set_has_fixed_size, true);

        this.isLLMHorizontal = typedArray.getBoolean(R.styleable.KienRecyclerView_nkien_set_llm_horizontal, false);

        this.isLLMVertical = typedArray.getBoolean(R.styleable.KienRecyclerView_nkien_set_llm_vertical, false);

        this.isGLMHorizontal = typedArray.getBoolean(R.styleable.KienRecyclerView_nkien_set_glm_horizontal, false);

        this.isGLMVertical = typedArray.getBoolean(R.styleable.KienRecyclerView_nkien_set_llm_vertical, false);

        this.columnsGLM = typedArray.getInt(R.styleable.KienRecyclerView_nkien_set_glm_column, 1);

        typedArray.recycle();

        setup(context);
    }

    private void setup(Context context) {
        setHasFixedSize(isFixedSize);
        if(isLLMVertical && !isLLMHorizontal && !isGLMVertical && !isGLMHorizontal)
            setLayoutManager(new LinearLayoutManager(context));
        else if(!isLLMVertical && isLLMHorizontal && !isGLMVertical && !isGLMHorizontal)
            setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        else if(!isLLMVertical && !isLLMHorizontal && isGLMVertical && !isGLMHorizontal)
            setLayoutManager(new GridLayoutManager(context, columnsGLM, VERTICAL, false));
        else if(!isLLMVertical && !isLLMHorizontal && !isGLMVertical && isGLMHorizontal)
            setLayoutManager(new GridLayoutManager(context, columnsGLM, HORIZONTAL, false));
        else
            setLayoutManager(new LinearLayoutManager(context));
    }
}
