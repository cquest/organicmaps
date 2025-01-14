package com.mapswithme.maps.base;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mapswithme.util.Utils;

public class BaseMwmFragment extends Fragment implements OnBackPressListener
{
  @Override
  public void onAttach(Context context)
  {
    super.onAttach(context);
    Utils.detachFragmentIfCoreNotInitialized(context, this);
  }

  public BaseMwmFragmentActivity getMwmActivity()
  {
    return Utils.castTo(getActivity());
  }

  @Override
  public boolean onBackPressed()
  {
    return false;
  }

  @NonNull
  public View getViewOrThrow()
  {
    View view = getView();
    if (view == null)
      throw new IllegalStateException("Before call this method make sure that fragment exists");
    return view;
  }
}
