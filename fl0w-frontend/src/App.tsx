
import Header from "./components/HeaderComponent";
import UserList from "./components/UserList";


function App() {
  return (
    <div className="min-h-screen bg-gray-50">
      <Header />
      <main className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
        <div className="px-4 py-6 sm:px-0">
          <div className="bg-white rounded-lg shadow p-6">
            <h2 className="text-2xl font-bold text-gray-900 mb-6">Users</h2>
            <UserList />
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;