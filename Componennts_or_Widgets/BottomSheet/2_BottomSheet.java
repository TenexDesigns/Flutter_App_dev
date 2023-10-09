In Flutter, there are three types of bottom sheets:

1. **Modal Bottom Sheet**: Modal bottom sheets are shown by using the `showModalBottomSheet` function. They restrict the user from interacting with the rest of the app until the bottom sheet is dismissed.

```dart
showModalBottomSheet(
  context: context,
  builder: (BuildContext context) {
    return Container(
      child: Wrap(
        children: <Widget>[
          ListTile(
            leading: Icon(Icons.music_note),
            title: Text('Music'),
            onTap: () => {},
          ),
          ListTile(
            leading: Icon(Icons.videocam),
            title: Text('Video'),
            onTap: () => {},
          ),
        ],
      ),
    );
  },
);
```
[Source 0](https://www.kindacode.com/article/flutter-bottom-sheet-examples/)

2. **Persistent Bottom Sheet**: Persistent bottom sheets remain visible even when the user interacts with other parts of the app. They can be created using the `ScaffoldState.showBottomSheet` function.

```dart
final GlobalKey<ScaffoldState> _scaffoldKey = GlobalKey<ScaffoldState>();

void _showBottomSheet() {
  _scaffoldKey.currentState.showBottomSheet<void>((BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        border: Border(top: BorderSide(color: Colors.black12)),
      ),
      child: Padding(
        padding: const EdgeInsets.all(32.0),
        child: Text('Persistent BottomSheet',
          textAlign: TextAlign.center,
          style: TextStyle(
            color: Theme.of(context).accentColor,
            fontSize: 24.0,
          ),
        ),
      ),
    );
  });
}
```
[Source 2](https://www.geeksforgeeks.org/bottomsheet-in-flutter/)

3. **Custom Bottom Sheet**: You can create a custom bottom sheet by using a combination of widgets such as `DraggableScrollableSheet`, `Container`, `Column`, `Row`, and more.

```dart
showModalBottomSheet(
  context: context,
  isScrollControlled: true,
  builder: (context) => DraggableScrollableSheet(
    expand: false,
    initialChildSize: 0.5,
    minChildSize: 0.25,
    maxChildSize: 1,
    builder: (BuildContext context, ScrollController scrollController) {
      return Container(
        color: Colors.blueGrey,
        child: ListView.builder(
          controller: scrollController,
          itemCount: 25,
          itemBuilder: (BuildContext context, int index) {
            return ListTile(title: Text('Item $index'));
          },
        ),
      );
    },
  ),
);
```
[Source 1](https://blog.logrocket.com/flutter-modal-bottom-sheet-tutorial-with-examples/)

These are the different types of bottom sheets available in Flutter. Each has its own use case and can be used depending on the requirements of your application.
