# needing-tools
Tools will help Kien's Project in the future
Setting for this library:
+ For Maven: add
   <dependency>
      <groupId>com.github.kiendtvt1411</groupId>
      <artifactId>needingtools</artifactId>
      <version>0.1.1</version>
      <type>pom</type>
   </dependency>

+ For Gradle file in module: add
    compile 'com.github.kiendtvt1411:needingtools:0.1.1'

This library has:
+ Tools for base Activity, Fragment:
   - Activity in future project will extends BaseActivity class
   and override methods setup(), getData(), updateUI() and releaseData().
   You must add initActivity() after setContentView(...) in onCreate().
   Activity will run: setup() -> getData() -> updateUI() in onCreate() and
   releaseData() in onDestroy()

   - Fragment in future project will extends BaseFragment class
   and override methods setup(View view), getData(), updateUI() and
   releaseData(). You must add initFragment(View view) after create view
   in onCreateView() method.
   Fragment will run: setup(view) -> getData() -> updateUI() in onCreateView()
   and releaseData() in onDetachView() 

+ Tools for utils
   - ColorUtils class contains some static function: convert color to hex
   string, convert color from id resource, change color of status bar
   
   - CommonUtils class contains some static function: check string != null,
   log information, convert old date time with old date formatter to new 
   date formatter new String[] {"dd/MM/yyyy", "HH:mm"}, detect date, check
   parse string to integer, parse html to string

   - DeviceUtils class: get type, language, country, id, name, version code
   of user's device

   - FileUtils class: get absolute sd card path, delete cache, size of cache
   file, size of dir file, convert file size to Gb-Mb-Kb, space size of storage,
   delete dir

   - KeyboardUtils class: open keyboard, close keyboard

   - PermissionUtils class: check if permission has been granted, request
   permission, request multi permissions
   
   - ScreenUtils class: size of witdh screen, size of height screen, convert dp 
   to px, convert px to dp

   - ToastUtils class: show snack bar toast with custom message

+ Tools for recycler view:
   - Custom recycler view with default attribute setHasFixedSize and default
   layout manager in KienRecyclerView.class
   - Generic class for Adapter and ViewHolder:
       Step 1: create model class
       Step 2: create view holder class extends BaseViewHolder.class and layout
       file of item
       Step 3: create adapter class extends GenericsRecyclerAdapter.class
       Step 4: create tag KienRecyclerView in layout file and in Activity or Dialog
       or Fragment contains that recycler view, create instance of adapter in step 3
       and setItem(List<model> list) with setListener(OnClickObjectListener listener)

+ Tools for data:
   - ToolDatabaseHelper: class will help you work with Sugar Database with some
   useful functions like insert item, insert list item, find item by query, find item
   by id, get all item, update item, delete item by id, delete item by query
   - ToolDownloadHelper: class will help you work with download file, download multi
   file:
       Step 1: create model class, must extends DefaultDownload.class model
       Step 2: create instance of ToolDatabaseHelper class
       Step 3: use download single file method or download multi file method
   - ToolPreferenceHelper: class will help you work with SharesPreferences with 2
   main functions save object data and get object data
   - ToolNetworkHelper: class will help you work with RESTful API by Retrofit 2, result
   will return in Callback class with RxJava & RxAndroid
       Step 1: create model class
       Step 2: create service class following Retrofit 2
       Step 3: create your own function for getting data from your API:
           use getServiceApi(your_service_class.class, base url)
           then use addService(Observable<your_model>, CallbackData<your_model>)
   - Note for me in the future: create AppManager class extend NetworkHelper, PrefHelper,
   DatabaseHelper, DownloadHelper, RealtimeHelper if needed; and in each above class, you
   must extends equivalent Tool class; then must initiate AppManager class in custom
   Application class 