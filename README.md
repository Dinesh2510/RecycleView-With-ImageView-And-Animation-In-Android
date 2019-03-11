# RecycleView-With-ImageView-And-Animation-In-Android

### down_to_up.xml


<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="500">

    <translate
        android:fromYDelta="50%p"
        android:interpolator="@android:anim/accelerate_decelerate_interpolator"
        android:toYDelta="0" />

    <alpha
        android:fromAlpha="0"
        android:interpolator="@android:anim/accelerate_decelerate_interpolator"
        android:toAlpha="1" />

</set>

### up_to_down.xml

<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="500">

    <translate
        android:fromYDelta="-25%"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toYDelta="0" />

    <alpha
        android:fromAlpha="0"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toAlpha="1" />

    <scale
        android:fromXScale="125%"
        android:fromYScale="125%"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="100%"
        android:toYScale="100%" />

</set>

### left_to_right.xml

<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="500">

    <translate
        android:fromXDelta="-100%p"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toXDelta="0" />

    <alpha
        android:fromAlpha="0.5"
        android:interpolator="@android:anim/accelerate_decelerate_interpolator"
        android:toAlpha="1" />

</set>

### right_to_left.xml

<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="500">

    <translate
        android:fromXDelta="100%p"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toXDelta="0" />

    <alpha
        android:fromAlpha="0.5"
        android:interpolator="@android:anim/accelerate_decelerate_interpolator"
        android:toAlpha="1" />

</set>

Now lets create the layoutAnimation for each of these animation sets.

### layout_animation_down_to_up.xml


    <?xml version="1.0" encoding="utf-8"?>
    <layoutAnimation xmlns:android="http://schemas.android.com/apk/res/android"
    android:animation="@anim/down_to_up"
    android:animationOrder="normal"
    android:delay="15%" />
    
    
### layout_animation_up_to_down.xml

    <?xml version="1.0" encoding="utf-8"?>
    <layoutAnimation xmlns:android="http://schemas.android.com/apk/res/android"
    android:animation="@anim/up_to_down"
    android:animationOrder="normal"
    android:delay="15%" />
    
    
### layout_animation_left_to_right.xml

    <?xml version="1.0" encoding="utf-8"?>
    <layoutAnimation xmlns:android="http://schemas.android.com/apk/res/android"
    android:animation="@anim/left_to_right"
    android:animationOrder="normal"
    android:delay="15%" />
    
    
### layout_animation_right_to_left.xml

    <?xml version="1.0" encoding="utf-8"?>
    <layoutAnimation xmlns:android="http://schemas.android.com/apk/res/android"
    android:animation="@anim/right_to_left"
    android:animationOrder="normal"
    android:delay="15%" />
    
Setting Layout Animation in XML and Programmatically
### We can set the Layout Animation on RecyclerView in XML in the following way:

     <android.support.v7.widget.RecyclerView
    android:layout_width="match_parent"
    android:layout_height="match_parent"                                        
    android:layoutAnimation="@anim/layout_animation_right_to_left"
    />
    
### Programmatically:

  int resId = R.anim.layout_animation_right_to_left;
  LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
  recyclerView.setLayoutAnimation(animation);
  
  
In order to re-run the animation or in case the data set of the RecyclerView has changed the following code is used:
Copy

     final LayoutAnimationController controller =
     AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_right_to_left);
    recyclerView.setLayoutAnimation(controller);
    recyclerView.getAdapter().notifyDataSetChanged();
    recyclerView.scheduleLayoutAnimation();
