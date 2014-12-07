package com.noisyninja.abheda_droid.pojo;

/**
 * Created by ir2pi on 12/6/2014.
 */
import com.noisyninja.abheda_droid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("ic_action_cross", "cross", R.drawable.imageholder));
        addItem(new DummyItem("ic_action_left", "left", R.drawable.imageholder));
        addItem(new DummyItem("ic_action_right", "right", R.drawable.imageholder));
        addItem(new DummyItem("ic_action_tick", "tick", R.drawable.imageholder));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public int resourceId;

        public DummyItem(String id, String content, int resourceId) {
            this.id = id;
            this.content = content;
            this.resourceId = resourceId;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}