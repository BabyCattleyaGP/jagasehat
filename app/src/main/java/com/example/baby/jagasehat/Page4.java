package com.example.baby.jagasehat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wenchao.cardstack.CardStack;

/**
 * Created by FZulfikar on 6/2/2018.
 */

public class Page4 extends AppCompatActivity implements CardStack.CardEventListener {

    private CardStack card_stack;
    private CardAdapter card_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        initImages();

        card_stack = (CardStack)findViewById(R.id.card_stack);
        card_stack.setContentResource(R.layout.card_layout);
        card_stack.setStackMargin(20);
        card_stack.setAdapter(card_adapter);

        card_stack.setListener(this);
    }

    private void initImages(){
        card_adapter = new CardAdapter(getApplicationContext(),0);
        card_adapter.add(R.drawable.capture);
        card_adapter.add(R.drawable.frontelephant);
        card_adapter.add(R.drawable.frontbird);
        card_adapter.add(R.drawable.card_bird);
        card_adapter.add(R.drawable.card_tree);
    }

    @Override
    public boolean swipeEnd(int i, float v) {
        return (v>300)?true:false;
    }

    @Override
    public boolean swipeStart(int i, float v) {
        return false;
    }

    @Override
    public boolean swipeContinue(int i, float v, float v1) {
        return false;
    }

    @Override
    public void discarded(int i, int i1) {

    }

    @Override
    public void topCardTapped() {

    }
}
