import logo from "./logo.svg";
import "./App.css";
import CounterUseReducer from "./components/CounterUseReducer";
import GetAxios from "./components/GetAxios";
import PostAxios from "./components/PostAxios";
import PutAxios from "./components/PutAxios";
import DeleteAxios from "./components/DeleteAxios";
import { Routes, Route, Link } from "react-router-dom";
import Home from "./components/Home";
import Contact from "./components/Contact";
import About from "./components/About";
import { lazy, Suspense } from "react";

function App() {
  // Lazy loaded components
  const Home = lazy(() => import("./components/Home"));
  const Contact = lazy(() => import("./components/Contact"));
  const About = lazy(() => import("./components/About"));
  const UserProfile = lazy(() => import("./components/UserProfile"));

  return (
    <div className="App">
      {/* <CounterUseReducer/> */}
      {/* <GetAxios/> */}
      {/* <PostAxios/> */}
      {/* <PutAxios/> */}
      {/* <DeleteAxios/> */}

      <nav>
        <Link to="/">Home</Link> | <Link to="/contact">Contact</Link> |{" "}
        <Link to="/about">About</Link>|{" "}
        <Link to="/user/emily">User Profile</Link>
      </nav>

      <Suspense fallback={<div>Loading...</div>}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/user/:username" element={<UserProfile />} />
          {/* Fallback route for 404 Not Found */}
          {/* This should be the last route in the Routes component */}
          {/* It will match any path that is not defined above */}
          <Route path="*" element={<h1>404 Page Not Found</h1>} />
        </Routes>
      </Suspense>
    </div>
  );
}

export default App;
