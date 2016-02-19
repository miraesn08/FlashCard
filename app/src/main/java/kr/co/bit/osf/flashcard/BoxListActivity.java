package kr.co.bit.osf.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import kr.co.bit.osf.flashcard.db.BoxDAO;
import kr.co.bit.osf.flashcard.db.BoxDTO;
import kr.co.bit.osf.flashcard.db.FlashCardDB;
import kr.co.bit.osf.flashcard.db.StateDAO;
import kr.co.bit.osf.flashcard.db.StateDTO;

public class BoxListActivity extends AppCompatActivity {
    final String TAG = "FlashCardBoxListTag";
    ListView Box_List_View;
    List<BoxDTO> BoxList;
    FlashCardDB db = null;
    StateDAO stateDao = null;
    StateDTO cardState = null;
    BoxDTO boxDTO;
    BoxDAO boxDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_list);

        // read state from db
        db = new FlashCardDB(this);
        stateDao = db;
        cardState = stateDao.getState();
        Log.i(TAG, "read card state:" + cardState);

        // state.boxId > 0 : start card list activity
        if (cardState.getBoxId() > 0) {
            Intent intent = new Intent(this, CardListActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this,BoxListModeActivity.class);
            startActivity(intent);
        }

    }

}