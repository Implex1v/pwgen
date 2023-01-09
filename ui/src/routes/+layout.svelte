<script lang="ts">
    import "../app.css";
    import { Icon } from "svelte-awesome";
    import { github } from "svelte-awesome/icons";
    const year = new Date().getFullYear();
</script>

<div class="bg-gray-900">
    <div class="container mx-auto py-6 pl-5">
        <p class="text-5xl">PWGEN</p>
    </div>

    <div class="container mx-auto">
        <div class="overflow-hidden w-full px-6 pt-4" style="min-height: 1000px">
            <slot />
        </div>
    </div>
</div>

<footer class="container mx-auto py-8">
    <div class="container flex px-3 py-8 ">
        <div class="w-full mx-auto flex flex-wrap">
            <div class="flex w-full lg:w-1/2 ">
                <div class="px-3 md:px-0">
                    <h3 class="font-bold">About</h3>
                    <p class="py-4 text-gray-400">
                        PWGEN is a web tool for password generation. <br />
                        &copy; PWGEN {year}
                    </p>
                </div>
            </div>
            <div class="flex w-full lg:w-1/2 lg:justify-end lg:text-right">
                <div class="px-3 md:px-0">
                    <h3 class="font-bold">Social</h3>
                    <ul class="list-reset items-center pt-3">
                        <li>
                            <a
                                class="inline-block no-underline hover:text-amber-700 py-1 text-lg text-gray-400 inline-block align-middle"
                                href="https://github.com/Implex1v/pwgen"
                            >
                                <span>GitHub</span>
                                <Icon data={github} scale={1.1} />
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>
